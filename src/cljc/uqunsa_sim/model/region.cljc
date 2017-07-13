(ns uqunsa-sim.model.region
  (:require #?(:clj [clojure.spec.alpha :as s]
               :cljs [cljs.spec.alpha :as s])
            [uqunsa-sim.model.shared :as m-shared]
            ))

;; A position isn't bounded, but is anywhere on an x/y axis. Maybe bound it later
(s/def ::position-value number?)
(s/def ::position-x ::position-value)
(s/def ::position-y ::position-value)
(s/def ::position (s/keys :req [::position-x ::position-y]))

(s/def ::distance (s/and number? pos?))
(s/def ::target-region (s/or :region-uid ::m-shared/uid
                             :region-uname ::m-shared/uname))
(s/def ::links (s/map-of ::target-region ::distance))

(s/def ::region-partial (s/keys :req [::position ::links]))
(s/def ::region (s/merge ::region-partial ::m-shared/object))

;; A mapping of region uids to their region
(s/def ::region-map (s/map-of ::m-shared/uid ::region))

(defn create-region
  "Creates a basic region. If not given an additional identifier, calculates the uid with a name hash"
  ([region-name region-x region-y links]
   (create-region region-name region-x region-y links (hash region-name)))
  ([region-name region-x region-y links uid]
   {::m-shared/uid uid
    ::m-shared/uname region-name
    ::position {::position-x region-x
                ::position-y region-y}
    ::links links}))
(s/fdef create-region
        :args (s/or
                ;; 4 arguments
                :4-args (s/cat :region-name ::m-shared/uname
                               :region-x ::position-x
                               :region-y ::position-y
                               :links ::links)
                :5-args (s/cat :region-name ::m-shared/uname
                               :region-x ::position-x
                               :region-y ::position-y
                               :links ::links
                               :uid ::m-shared/uid))
        :ret ::region)

(defn add-region
  "Adds a region to a region map"
  [region-map region]
  (merge region-map {(::m-shared/uid region) region})
  )
(s/fdef add-region
        :args (s/cat :region-map ::region-map :region ::region)
        :ret ::region-map)
