"""
Configure logging for the QA Test Framework.

Requirements:
1. Console handler: Show INFO and above, concise format
2. File handler: Capture DEBUG and above, detailed format with timestamps
3. Use a RotatingFileHandler (max 1MB, keep 3 backups)
"""

import logging
from logging.handlers import RotatingFileHandler


def setup_logging(log_file="test_framework.log", console_level=logging.INFO):
    """Configure and return the root logger for the framework.

    Args:
        log_file: Path to the log file
        console_level: Minimum level for console output

    Returns:
        logging.Logger configured with both handlers
    """
    # TODO: Create logger named "qa_framework"
    qa_framework = logging.getLogger("qa_framework")

    qa_framework.basicConfig(filename=log_file, level=console_level)

    
    # TODO: Add StreamHandler for console (INFO+)
    console_handler = logging.StreamHandler()
    console_handler.setLevel(logging.INFO)
    

    qa_framework.addHandler(console_handler)
    # TODO: Add RotatingFileHandler for file (DEBUG+)
    file_handler = logging.RotatingFileHandler()
    file_handler.setLevel(logging.DEBUG)

    qa_framework.addHandler(file_handler)
    # TODO: Set appropriate formatters on each handler
    formatter = logging.Formatter("%(asctime)s | %(levelname)-8s | %(name)s:%(lineno)d | %(message)s",
     datefmt="%Y-%m-%d %H:%M:%S")

    console_handler.setFormatter(formatter)
    file_handler.setFormatter(formatter)
    # TODO: Return the configured logger
    return qa_framework