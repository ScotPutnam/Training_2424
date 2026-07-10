# Pytest-Mock Basics
# pytest-mock provides the "mocker" fixture
# automatically cleans up patches after each test
# No context managers or decorators needed
# Same API as unittest.mock but more Pythonic
# Install with: pip install pytest-mock

import os
import pytest
import os
from services import UserService, User, UserRepository, EmailClient

#basic mock creation
def test_mocker_creates_mocks(mocker):
    """
    The mocker fixture creates mock objects.

    mocker.Mock() creates a basic mock.
    mocker.MagicMock() creates a mock with magic methods.
    """
    #Creates basic mock
    mock_func = mocker.Mock()
    mock_func.return_value = 42

    result = mock_func()

    assert result == 42
    mock_func.assert_called_once()

def test_mocker_mock_with_spec(mocker):

    mock_repo = mocker.Mock(spec=UserRepository)

    mock_repo.find_by_id.return_value = User(1, "John", "john@test.com")

    user = mock_repo.find_by_id(1)
    assert user.name == "John"

def test_mocker_patch(mocker):
    mock_exists = mocker.patch('os.path.exists' , return_value = True)

    assert os.path.exists('/any/path/at/all') is True
    assert os.path.exists('/fake/path') is True

    mock_exists.asser_called()

def test_mocker_patch_dict(mocker):

    mocker.patch.dict(os.environ, {
        'API_KEY' : 'test-key-123',
        'DEBUG':'true'
    })
    
    assert os.environ['API_KEY'] == 'test-key-123'
    assert os.environ['DEBUG'] == 'true'

def test_mocker_patch_object(mocker):

    user = User(1, "original", "patched@test.com")

    assert user.email == 'patched@test.com'
    assert user.name == "original"

def test_user_service_with_mock_repo(mocker):

    mock_repo = mocker.Mock(spec=UserRepository)
    mock_repo.find_by_id.return_value = User(1, "John", "John ")
    service = UserService(repository=mock_repo)

    user = service.get_user(1)

    assert user.name == "John"
    mock_repo.find_by_id.assert_called_once_with(1)

def test_user_service_create_user(mocker):

    mock_repo = mocker.Mock(spec=UserRepository)
    mock_email = mocker.Mock(spec=EmailClient)

    mock_repo.find_by_email.return_value = None
    mock_repo.save.side_effect = lambda u: User(id=100, name=u.name, email=u.email)

    mock_email.send.return_value = True

    service = UserService(repository=mock_repo, email_client=mock_email)
    user = service.create_user("Alice", "alice@test.com")

    assert user.id == 100
    assert user.name == "Alice"

    mock_repo.save.asser_called_once()
    mock_email.send.assert_called_once()

#   mocker.spy()
def test_mocker_spy(mocker):
    """
    Spy wraps a real function to traCK CALLS
    The function still executes but you can verify it was called
    """

    # arrange
    mock_repo = mocker.Mock(spec=UserRepository)
    mock_email = mocker.Mock(spec=EmailClient)

    service = UserService(mock_repo, mock_email)

    user = User(id=1, name="Alice", email="alice@example.com")
    mock_repo.find_by_id.return_value = user
    mock_repo.save.return_value = user

    spy = mocker.spy(service, "get_user")

    # act
    result = service.deactivate_user

    # Assert
    assert result.active is False

    spy.assert_called_once_with(1)