# juint
juint is a simple wrapper to hopefully make it easier to work with unsigned and signed 8, 16, and 32-bit integers in Java.

## Background
This an old open source project I started as a way to make it easier to work with unsigned integers in Java when manipulating binary files. I think the inspiration came from C and was something I needed to help with other projects where I needed to do things like read an unsigned 8-bit integer and had a hard time remembering to use `short` instead of `byte`. The original code is still hosted at [sourceforge](https://sourceforge.net/projects/juint). The code hosted here is an import from Subversion using reposurgeon.


## Build
1. `ant test`
1. `ant dist`