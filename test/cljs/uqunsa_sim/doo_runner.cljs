(ns uqunsa-sim.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [uqunsa-sim.core-test]))

(doo-tests 'uqunsa-sim.core-test)

