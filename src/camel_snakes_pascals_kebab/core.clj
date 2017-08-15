(ns camel-snakes-pascals-kebab.core
  (:gen-class)
  (:require [camel-snakes-pascals-kebab.transformation :as transform]
            [clojure.string :as str]))

(defn- split-words
  "Split any format in words"
  [some-format]
  (str/split some-format #"-|_|(?=[A-Z])"))

(defn format
  "Formats the input with a given transformer function"
  [input _ transformer]
  (let [words (split-words (name input))]
    (keyword ((transform/resolve-transforming-fn transformer) words))))