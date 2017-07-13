(ns uqunsa-sim.test.model.region
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [clojure.spec.test.alpha :as stest]
            [clojure.test :refer :all]
            [uqunsa-sim.model.shared :as m-shared]
            [uqunsa-sim.model.region :as m-region]
            [uqunsa-sim.test.model.shared :refer [instrument-namespace]]
            ))

(deftest instrument-everything
  (testing "Namespace instrumentation"
    (map #(is (= true (-> % :clojure.spec.test.check/ret :result)))
         (apply concat (instrument-namespace 'uqunsa-sim.model.region)))))

