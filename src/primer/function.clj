(ns primer.function
  (:require [datomic.client.api :as d]
            [primer.mbrainz :as mb]))

(defn custom-fn
  [s]
  (or (clojure.string/starts-with? s "は")
      (clojure.string/starts-with? s "荒")))

(comment
 ; calling java instance method
  (d/q '[:find ?name
         :where
         [_ :artist/name ?name]
         [(.contains ^String ?name "ス")]]
       (d/db mb/conn))
  ; calling clojure func
  (d/q '[:find ?name
         :where
         [_ :artist/name ?name]
         [(clojure.string/starts-with? ?name "ザ")]]
       (d/db mb/conn))
  ; custom func is not supported
  ;CompilerException clojure.lang.ExceptionInfo: Server Error 
  ;{:datomic.client-spi/request-id "26a0d891-fdc2-400d-ba57-08c402725f93", :cognitect.anomalies/category 
  ; :cognitect.anomalies/fault, :cognitect.anomalies/message "Server Error", 
  ; :dbs [{:database-id "73a18ece-869b-48af-a6af-5b778ea1417e", :t 28, :next-t 29, :history false}]}, compiling:(:24:5)
  #_(d/q '[:find ?name
           :where
           [_ :artist/name ?name]
           [(primer.function/custom-fn ?name)]]
         (d/db mb/conn))
  (d/q '[:find ?name
         :where
         [_ :artist/name ?name]
         (or [(clojure.string/starts-with? ?name "は")]
             [(clojure.string/starts-with? ?name "荒")])]
       (d/db mb/conn)))
