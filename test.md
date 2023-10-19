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

For detailed information on the Spins class, refer to Spins Class Documentation.

## Driver Class

The Driver class implements the Metropolis Monte Carlo algorithm for minimizing the system's energy and finding equilibrium states. It provides a method to drive the simulation.

For detailed information on the Driver class, refer to Driver Class Documentation.

# Technical Details

## Metropolis Monte Carlo Algorithm

The Metropolis Monte Carlo algorithm is employed to minimize the system's energy. It involves random selection and modification of spins, followed by acceptance or rejection based on energy changes. The process is repeated a specified number of times (n) to reach equilibrium states.

## System Energy Calculation

The system's total energy is computed as the sum of individual energy terms, which include Zeeman energy, anisotropy energy, and exchange energy. These terms are evaluated for each spin configuration.

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
