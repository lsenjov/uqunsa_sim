(ns uqunsa-sim.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[uqunsa_sim started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[uqunsa_sim has shut down successfully]=-"))
   :middleware identity})
