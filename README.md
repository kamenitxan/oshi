OSHI
====

[![Build Status](https://travis-ci.org/dblock/oshi.svg)](https://travis-ci.org/dblock/oshi)

Oshi is a free JNA-based (native) operating system information library for Java. It doesn't require any additional native DLLs and aims to provide a cross-platform implementation to retrieve system information, such as version, memory, CPU, disk, etc.

Download
--------

* [Oshi 1.1](http://code.dblock.org/downloads/oshi/oshi-1.1.zip)

Where are we?
-------------

Oshi is a very young project. We'd like *you* to contribute a *nix port. Read the [project intro](http://code.dblock.org/introducing-oshi-operating-system-and-hardware-information-java).

Current supported platform
--------------------------

- Windows
- Linux
- Mac OS-X

Current supported feature
-------------------------

### Operating Systems ###

* Manufacturer
  - GNU/Linux
  - Microsoft
  - Apple

* Family
  - Mac OS X
  - Windows
  - Linux Distribution (Fedora, Ubuntu, ...)

* Version
  - Version number
  - Codename
  - Build

### Hardware ###

* How much physical RAM
* How much available RAM
* How many CPUs (core * thread)
* CPU load % (OSX and Linux)
* GPU vendor, name and memory (OSX and Linux)

Sample Output
-------------

Here's sample tests output:

For Windows:

```
Microsoft Windows 7
2 CPU(s):
 Intel(R) Core(TM)2 Duo CPU T7300  @ 2.00GHz
 Intel(R) Core(TM)2 Duo CPU T7300  @ 2.00GHz
Memory: 532.1 MB/2.0 GB
CPU load: 70.59%
GPU: NVIDIA GeForce GTX 650 Ti 1 GB
```

For Linux:

```
GNU/Linux Fedora 20 (Heisenbug)
8 CPU(s):
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
 Intel(R) Core(TM) i7-3720QM CPU @ 2.60GHz
Memory: 21.0 GB/31.0 GB
CPU load: 70.59%
GPU: NVIDIA GeForce GTX 650 Ti 1 GB
```

For Mac OS X:

```
Apple Mac OS X 10.9.5 (Mavericks) build 13F34
4 CPU(s):
 Intel(R) Core(TM) i7-2677M CPU @ 1.80GHz
 Intel(R) Core(TM) i7-2677M CPU @ 1.80GHz
 Intel(R) Core(TM) i7-2677M CPU @ 1.80GHz
 Intel(R) Core(TM) i7-2677M CPU @ 1.80GHz
Memory: 17.3 MB/4 GB
CPU load: 70.59%
GPU: NVIDIA GeForce GTX 650 Ti 1 GB
```

How is this different from ...
------------------------------

* [Sigar](http://www.hyperic.com/products/sigar): Sigar is GPL. Oshi is distributed under the MIT license. Oshi also uses [JNA](https://github.com/twall/jna) and doesn't require a native DLL to be installed.

License
-------

This project is licensed under the [Eclipse Public License 1.0](LICENSE.txt).
