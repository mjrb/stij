# stij

The beginnings of a Clojurescript library to use MongoDB stitch.
hopefully in a slightly more Clojurescript way

## Overview

WIP this eventually should become a CLJSJS package but I'm publishing the work I've done for now until it gets mature enough (and until I grow up and figure out how to package properly)

if you have any questions or want to contribute feel free to open issues/pull requests

right now this wraps the Typescript MongoDB Stitch browser sdk on npm
I used yarn and webpack to make the sdk accessible from Clojurescript

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2018 Mickey J Winters

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.