(ns primer.aggregation
  (:require [clojure.pprint :as p]
            [datomic.client.api :as d]
            [primer.mbrainz :as mb]))

(comment
  (let [db (d/db mb/conn)
        artist-name "The Beatles"]
    (->> (d/q '[:find (max ?duration)
                :in $ ?artist-name
                :where
                [?a :artist/name ?artist-name]
                [?t :track/artists ?a]
                [?t :track/duration ?duration]]
              db artist-name)
         first
         first
         (d/q '[:find ?name
                :in $ ?artist-name ?duration
                :where
                [?t :track/duration ?duration]
                [?a :artist/name ?artist-name]
                [?t :track/artists ?a]
                [?t :track/name ?name]]
              db artist-name))))
