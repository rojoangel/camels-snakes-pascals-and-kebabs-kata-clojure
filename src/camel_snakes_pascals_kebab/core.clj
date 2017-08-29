(ns camel-snakes-pascals-kebab.core
  (:gen-class)
  (:require [camel-snakes-pascals-kebab.format :as format]
            [clojure.string :as str]))

(defn- split-words
  "Split any format in words"
  [formatted-input]
  (str/split formatted-input #"-|_|(?=[A-Z])"))

(defmulti create-container map-entry?)

(defmethod create-container true [input]
  [])

(defmethod create-container :default [input]
  (empty input))

#_(defn- create-container [input]
  (if (map-entry? input)
    []
    (empty input)))

(defmulti format (fn [input _ _] (cond (coll? input) :coll (keyword? input) :keyword :else :other)))

(defmethod format :coll [input _ format-style]
  (into (create-container input) (map (fn [x] (format x _ format-style)) input)))

(defmethod format :keyword [input _ format-style]
  (let [words (split-words (name input))]
    (keyword ((format/resolve-transforming-fn format-style) words))))

(defmethod format :default [input _ format-style]
  input)

#_(defn format
  "Formats the input to the given format name"
  [input _ format-style]
  (cond
    (coll? input)
    (into (create-container input) (map (fn [x] (format x _ format-style)) input))

    (keyword? input)
    (let [words (split-words (name input))]
      (keyword ((format/resolve-transforming-fn format-style) words)))

    :else
    input))