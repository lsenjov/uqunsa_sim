(ns uqunsa-sim.db.regions
  (:require [uqunsa-sim.db.core :as db]
            [uqunsa-sim.model.shared :as m-shared]
            [uqunsa-sim.model.region :as m-region]
            ))

(db/get-all-regions)

(defn get-all-regions
  "Returns a collection of all regions"
  []
  (->> (db/get-all-regions)
       (map (comp clojure.edn/read-string :object))
       ))
(defn store-region
  "Stores a region in the database.
  NOTE: If the region uid already exists, it will overwrite the old region with the new one. YOU HAVE BEEN WARNED."
  [{::m-shared/keys [uid uname]
    ::m-region/keys [links] ; Links is unused, but a reminder it still exists
    {position-x ::m-region/position-x position-y ::m-region/position-y} ::m-region/position
    :as object
    }]
  (db/create-region!
    {:id uid
     :name uname
     :regionx position-x
     :regiony position-y
     :object (pr-str object)}))
(defn get-region
  "Returns either a region with the same uid/uname, or nil"
  [search]
  (if-let [region (first (db/get-region {:search search}))]
    (clojure.edn/read-string (:object region))))

(comment
  (get-all-regions)
  (store-region (m-region/create-region "Test-region" 90 40 {"Antartica" 8}))
  (get-region "Test-region")
  (get-region "Unknown")
  )
