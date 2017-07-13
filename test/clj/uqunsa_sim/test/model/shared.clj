(ns uqunsa-sim.test.model.shared
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [clojure.spec.test.alpha :as stest]
            [clojure.test :refer :all]
            [uqunsa-sim.model.shared :as m-shared]
            ))

(defn instrument-namespace
  "Instruments and checks everything in the specified namespace, may take a while"
  [ns]
  (->> (stest/enumerate-namespace ns)
       (map stest/instrument)
       (map stest/check)
       ;(map stest/summarize-results)
       ))
