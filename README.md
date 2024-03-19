# Compound Plate Manager
This project provides a implementation of a compound plate manager, which allows users to register compounds, assign compounds to wells, copy the contents of wells, get compounds in a given well, and get a list of all compounds on a plate.

## Design

Compound class: represents a chemical compound and is responsible for storing its unique identifier (compoundId). It provides methods to retrieve and set the compound ID.

Well class: represents a well in a plate. It maintains a collection of compounds contained within it. Its primary responsibility is to manage the compounds stored within the well, including adding compounds and retrieving them.

Plate class: represents a plate containing multiple wells. It manages a collection of wells and provides methods to interact with the compounds within each well. The Plate class is responsible for adding wells, retrieving specific wells, and obtaining all compounds across the plate.

RequirementManager class: responsible for managing requirements related to compounds and wells. It provides functionality to register compounds, assign compounds to wells, and copy the contents of wells.
## Assumptions

In the context of this program, the following assumptions have been made:
1. Persistence/saving/storage of data is not required.
2. The program will be run as a single application and included in an existing codebase.
3. The program will be distributed as part of the existing application, without the need for deployment or build scripts. There is no requirement for a front-end interface.

## Running Tests

The project includes JUnit5 tests to ensure the correctness of the implemented functionality. To run the tests, follow these steps:

1. Ensure you have JUnit5 installed on your system.
2. Navigate to the `test` directory of the project.
3. Run the tests.