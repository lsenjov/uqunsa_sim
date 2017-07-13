(ns uqunsa-sim.model.shared
  (:require #?(:clj [clojure.spec.alpha :as s]
               :cljs [cljs.spec.alpha :as s])
            ))

;; uids and unames should be unique
(s/def ::uid integer?)
(s/def ::uname (s/and string? (complement empty?)))
(s/def ::object (s/keys :req [::uid ::uname]))
