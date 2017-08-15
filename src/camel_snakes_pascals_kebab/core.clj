(ns camel-snakes-pascals-kebab.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn- camel-case
  "Converts the input to camel case."
  [input]
  (str/join "" (concat (str/lower-case (first input)) (map str/capitalize (rest input)))))

(defn- snake-case
  "Converts the input to snake case."
  [input]
  (str/join "_" (map str/lower-case input)))

(defn- pascal-case
  "Converts the input to pascal case."
  [input]
  (str/join "" (map str/capitalize input)))

(defn- kebab-case
  "Converts the input to pascal case."
  [input]
  (str/join "-" (map str/lower-case input)))

(defn- split-words
  "Split any format in words"
  [some-format]
  (clojure.string/split some-format #"-|_|(?=[A-Z])"))

(defn- resolve-transforming-fn
  "Returns the transforming function corresponding to the name passed in"
  [transformer]
  (resolve (symbol "camel-snakes-pascals-kebab.core" (name transformer))))

(defn format
  "Formats the input with a given transformer function"
  [input _ transformer]
  (let [words (split-words (name input))]
    (keyword ((resolve-transforming-fn transformer) words))))