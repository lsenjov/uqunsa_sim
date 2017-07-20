(ns uqunsa-sim.db.core
  (:require
    [clj-time.jdbc]
    [clojure.java.jdbc :as jdbc]
    [conman.core :as conman]
    [uqunsa-sim.config :refer [env]]
    [mount.core :refer [defstate]])
  (:import [java.sql
            BatchUpdateException
            PreparedStatement]))

(defstate ^:dynamic *db*
           :start (conman/connect! {:jdbc-url (env :database-url)})
           :stop (conman/disconnect! *db*))

(conman/bind-connection *db* "sql/queries.sql")

(comment
  (:stop *db*)
  (:start *db*)
  (create-user!
    {:id         "1"
     :first_name "Sam"
     :last_name  "Smith"
     :email      "sam.smith@example.com"
     :pass       "pass"})
  (get-user {:id 1})
  (get-all-regions)
  (create-region!
    {:id "1"
     :name "Antartica"
     :regionx 15.0
     :regiony 180.0
     :object "{:edn test}"})
  ) ; End comment
