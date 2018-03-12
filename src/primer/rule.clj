(ns primer.rule
  (:require [datomic.client.api :as d]
            [primer.mbrainz :as mb]))

(def rules
  '[[(track-info ?artist ?name ?duration)
     [?track :track/artists ?artist]
     [?track :track/name ?name]
     [?track :track/duration ?duration]]])

(comment
  (d/q '[:find ?name ?duration
         :in $ % ?aname
         :where [?artist :artist/name ?aname]
         (track-info ?artist ?name ?duration)]
       (d/db mb/conn) rules "The Beatles"))
