# Magnetic Skyrmion Simulation

## Overview

This project offers a simulation environment for studying the emergence and behavior of magnetic skyrmions in a two-dimensional spin lattice. The simulation is based on a comprehensive implementation of various energy terms, including Zeeman energy, uniaxial anisotropy, exchange energy, and Dzyaloshinskii-Moriya energy. The Metropolis Monte Carlo algorithm is employed to minimize the system's energy and identify equilibrium states.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Classes and Modules](#classes-and-modules)
  - [Spins Class](#spins-class)
  - [System Class](#system-class)
  - [Driver Class](#driver-class)
- [Technical Details](#technical-details)
  - [Metropolis Monte Carlo Algorithm](#metropolis-monte-carlo-algorithm)
  - [Energy Computations](#energy-computations)
  - [Random Spin Generation](#random-spin-generation)
- [Examples](#examples)
- [Performance Considerations](#performance-considerations)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Prerequisites

Before running this simulation, ensure you have the following prerequisites installed:

- Python (>= 3.6)
- NumPy (>= 1.18)
- Matplotlib (>= 3.2)

## Installation


- git clone https://github.com/yourusername/magnetic-skyrmion-simulation.git
- cd magnetic-skyrmion-simulation
- pip install -r requirements.txt


## Usage

To perform a simulation, follow these steps:

1. Initialize a spin lattice using the Spins class.
2. Randomize the spins or set an initial spin configuration.
3. Visualize the spin lattice if desired.
4. Initialize the Driver class.
5. Drive the system using the Metropolis Monte Carlo algorithm.

For detailed usage instructions and code examples, refer to the Examples section.

# Classes and Modules

## Spins Class

The Spins class represents a field of spins on a two-dimensional lattice. Each spin is a three-dimensional vector (sx, sy, sz). The class provides methods for initialization, normalization, and visualization of the spin lattice.

The spins class consists of 4 methods; mean, normalise, randomise and plot.
## `mean(self)`

- **Description:** This method calculates the mean direction of all the spins in the lattice.
- **Details:**
    - I compute the sum of the x, y, and z components of the spins in the lattice.
    - Then, it calculates the mean by dividing the sum by the product of the lattice dimensions (nx * ny).
    - The result is returned as an array with three components (mx, my, mz).

## `__abs__(self)`

- **Description:** This special method computes the absolute value (magnitude) of each spin in the lattice.
- **Details:**
    - I first square each component of the spins and sum them along the last axis ([-1]).
    - Then, I take the square root of the resulting sum, which gives the magnitude of each spin.
    - The result is returned as an array of magnitudes.

## `normalise(self)`

- **Description:** This method normalises the magnitude of all spins in the lattice to 1.
- **Details:**
    - It divides each spin vector by its magnitude (calculated using `__abs__`) in order to make sure all spins have unit length.
    - Note: This method will fail the tests  if the `__abs__` method is not implemented.

## `randomise(self)`

- **Description:** This method initialises the lattice with random spins.
- **Details:**
    - It generates random spin vectors with components in the range of -1 to 1.
    - After the spins ahve been generated, they are normalised to ensure they all have unit length.

## `plot(self, **kwargs)`

- **Description:** This method visualises the spin lattice.
- **Details:**
    - It creates a quiver plot to represent the spins.
    - The size of the figure/frame is specified using the `figsize` argument.
    - The x and y components from the spins are extracted, and the quiver plot is created with arrows representing the spin directions.
    - The final visualisation displays the lattice structure and spin directions.
    - The plot is displayed with labels and a title.

    Note: Some commented-out code suggest adjustments that can be made to alter the plot's appearance, like changing the scale or colormap. For example, playing with the "scale" parameter reveals the spin/lattice formation.
  
  Additional information about quiverplots can be found here. https://matplotlib.org/stable/api/_as_gen/matplotlib.pyplot.quiver.html




## Driver Class

The Driver class implements the Metropolis Monte Carlo algorithm whose purpose involves minimising the system's energy and finding the equilibrium states. It provides a method to drive the simulation.

####Metropolis Monte Carlo Algorithm

The Metropolis Monte Carlo algorithm is used to minimise the system's energy. It randomly selcts and modifies spins, this is then followed by acceptance or rejection based on energy changes, if the enerygy delta is higher than 0, we accept the changed spin, else we reject it and stay with the original spin. The process is repeated n times to reach equilibrium states.

## System Energy Calculation

The system's total energy is computed as the sum of individual energy terms, which include Zeeman energy, anisotropy energy, and exchange energy. These terms are evaluated for each spin configuration.
The systems class consists of these 5 functions:
#### `energy(self) -> float`

- Description: This function computes the total energy of the system as the sum of all individual energy terms which is returned from the energy() function.
- Returns: Total energy of the system.

#### `zeeman(self) -> float`

- Description: Calculates the Zeeman energy contribution.
- Returns: Total Zeeman energy.

#### `anisotropy(self) -> float`

- Description: Calculates the uniaxial anisotropy energy contribution.
- Returns: Total uniaxial anisotropy energy.

#### `exchange(self) -> float`

- Description: Calculates the exchange energy contribution.
- Returns: Total exchange energy.

#### `dmi(self) -> float`

- Description: Calculates the Dzyaloshinskii-Moriya energy contribution.
- Returns: Total Dzyaloshinskii-Moriya energy.



# Examples

Below is an example demonstrating the simulation process:

```python
# Initialize a spin lattice
spins = Spins(n=(5, 5))

# Randomize spins
spins.randomise()

# Visualize the spin lattice
spins.plot()

# Initialize the driver
driver = Driver()

# Drive the system using Metropolis Monte Carlo algorithm
driver.drive(spins, n=100000)
