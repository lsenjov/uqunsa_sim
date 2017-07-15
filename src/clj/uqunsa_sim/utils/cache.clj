(ns uqunsa_sim.utils.cache
  (:require [clojure.core.cache :as cache]
            )
  )

(defn generic-lu-cache-factory
  "Returns a cached function for looking up values. Takes a function which is used for getting values on misses."
  ([get-fn]
   (generic-lu-cache-factory get-fn 32))
  ([get-fn threshold]
   (partial swap!
            (atom (cache/lu-cache-factory {} :threshold threshold))
            (partial cache/through get-fn)
            )))
  
(comment
  (def c (generic-lu-cache-factory hash 4))

  (c :a)
  (c :b)
  (c :c)
  (c :d)
  (c :e)
  (c :f)
  )
