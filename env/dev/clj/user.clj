(ns user
  (:require [mount.core :as mount]
            [uqunsa-sim.figwheel :refer [start-fw stop-fw cljs]]
            uqunsa-sim.core))

(defn start []
  (mount/start-without #'uqunsa-sim.core/repl-server))

(defn stop []
  (mount/stop-except #'uqunsa-sim.core/repl-server))

(defn restart []
  (stop)
  (start))


