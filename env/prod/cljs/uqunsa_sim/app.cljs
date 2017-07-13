(ns uqunsa-sim.app
  (:require [uqunsa-sim.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
