(ns uqunsa-sim.test.model.region
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [clojure.spec.test.alpha :as stest]
            [clojure.test :refer :all]

            [uqunsa-sim.model.shared :as m-shared]
            [uqunsa-sim.model.region :as m-region]

            [uqunsa-sim.test.utils :as tutils]
            ))

(comment
  ;; Check all specs work
  (tutils/instrument-and-check-namespace 'uqunsa-sim.model.region)
  )
