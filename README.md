
# maDMPs Backend Project for Medical University of Graz

This repository contains the backend source code for the DMP Tool MUG, developed in collaboration with the Research Data Management team at Graz University of Technology. The backend is based on the principles of machine-actionable Data Management Plans (maDMPs) and has been adapted to meet the specific needs of medical research at MUG.

This project uses Quarkus, the Supersonic Subatomic Java Framework. To learn more about Quarkus, visit: [https://quarkus.io/](https://quarkus.io/).

## Running the Application in Dev Mode

You can run the application in dev mode, with live coding enabled, using the following command:

```shell
mvn compile quarkus:dev
```

> **_NOTE:_** Quarkus ships with a Dev UI, which is accessible in dev mode only at `http://localhost:8080/q/dev/`.

## Adaptation for MUG DMP Tool

This project is based on the DAMAP backend developed in cooperation between TU Wien and TU Graz, but has been adapted to meet the specific needs of the MUG DMP Tool. The adaptation focuses on institutional integration, allowing researchers at MUG to efficiently manage their Data Management Plans (DMPs) by leveraging existing systems at the institution.

## Installation

The DMP Tool MUG can be deployed using several methods. The recommended approach is running the application as containers. Detailed installation instructions are available in the [INSTALLATION.md](INSTALLATION.md) file.

## Customisation

For customising the backend to integrate with MUG's institutional systems, refer to the [CUSTOMISING.md](CUSTOMISING.md) file.


