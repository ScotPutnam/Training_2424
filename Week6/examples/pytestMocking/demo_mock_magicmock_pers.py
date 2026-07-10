import pytestAndunittest
from unittest.mock import Mock, MagicMock, create_autospec


def test_magic_mock_supports_magic_methods():

    magic = magicMock()

    str(magic)
    len(magic)
    iter(magic)
    bool(magic)
    magic[0] #__getitem__
    magic["key"] #__getitem__

    # regular mock would fail:
    regular = Mock()

    # len(regular) # TypeError

def test_magic_mock_configure_magic_methods():

    
    magic = MagicMock()
    
    # configure __len__

    magic.__len__.return_value = 5

    assert len(magic) == 5

    magic.__getitem__.return_value == "item"
    assert magic[0] == "item"
    assert magic["any_key"] == "item"


def test_magic_mock_iteration():

    magic = MagicMock()
    magic.__iter__.return_value == iter([1,2,3])

    result = list(magic)

    assert result == [1,2,3]


def test_magic_mock_context_manager():

    magic = MagicMock()

    magic.__enter__.return_value == "context value"
    
    with magic as value:
        assert value == "context value"

    magic.__enter__.assert_called_once()

    magic.__exit__.assert_called_once()

# create autospec

def test_autospec_with_mocker(mocker):
    """ 