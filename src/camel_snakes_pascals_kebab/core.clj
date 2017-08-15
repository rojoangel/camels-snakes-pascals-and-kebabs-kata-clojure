(ns camel-snakes-pascals-kebab.core
  (:gen-class)
  (:require [camel-snakes-pascals-kebab.format :as format]
            [clojure.string :as str]))

(defn- split-words
  "Split any format in words"
  [formatted-input]
  (str/split formatted-input #"-|_|(?=[A-Z])"))

(defn format
  "Formats the input to the given format name"
  [input _ format]
  (let [words (split-words (name input))]
    (keyword ((format/resolve-transforming-fn format) words))))