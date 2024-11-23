# University Management System

A Java-based university management system that handles student enrollment, faculty management, and basic administrative operations. The system uses object-oriented programming principles and implements serialization for data persistence.

## Features

- Student Management
  - Admit new students
  - Search for existing students
  - View student information (name, DOB, major)
  - Expel students
  - List all enrolled students

- Faculty Management
  - Hire new faculty members
  - Search for existing faculty
  - View faculty information (name, DOB, assigned courses)
  - Fire faculty members
  - List all faculty members

- Academic Programs
  - Predefined list of majors
  - Predefined list of courses
  - Course assignment to faculty

- Data Persistence
  - Save system state using Java serialization
  - Load previous state on startup

## Project Structure

- `Person.java`: Base class for both students and faculty members
- `School.java`: Interface defining core university operations
- `Student.java`: Extends Person class with student-specific attributes
- `Faculty.java`: Extends Person class with faculty-specific attributes
- `University.java`: Implementation of the School interface with core business logic
- `UniversityDriver.java`: Main application with command-line interface

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Basic understanding of command-line operations

## Getting Started

1. Compile all Java files:
```bash
javac *.java
```

2. Run the program:
```bash
java UniversityDriver
```

## Usage

The system provides a command-line interface with the following commands:

- `hire`: Add a new faculty member
- `admit`: Enroll a new student
- `find student`: Search for and display student information
- `find faculty`: Search for and display faculty information
- `list students`: Display all enrolled students
- `list faculty`: Display all faculty members
- `fire faculty`: Remove a faculty member
- `expel student`: Remove a student
- `quit`: Save data and exit the program

## Data Model

### Person Class
- Base class with common attributes:
  - First name
  - Last name
  - Date of birth (month, day, year)

### Student Class
- Extends Person
- Additional attributes:
  - Major

### Faculty Class
- Extends Person
- Additional attributes:
  - Array of assigned courses

## Sample Data

The system comes preloaded with sample data including:
- Faculty members with superhero names (e.g., Bruce Wayne, Diana Prince)
- Students with superhero names (e.g., Peter Parker, Tony Stark)
- Predefined majors:
  - Hardware Architecture
  - Information Analytics
  - Quantum Computing
  - Undecided
- Various computer science and engineering courses

## Data Persistence

- Data is automatically saved to a file named `[universityName].ser` when exiting
- Previous data is loaded automatically on startup
- Uses Java's Serialization mechanism for object persistence

## Error Handling

The system includes basic error handling for:
- Invalid commands
- Non-existent students/faculty
- Invalid course assignments
- Invalid major selections


## Notes

- The university name and motto are set during initialization
- All searches are case-insensitive
- The system maintains separate lists for students and faculty
- Course assignments for faculty are validated against the predefined course list
- Student majors are validated against the predefined major list
