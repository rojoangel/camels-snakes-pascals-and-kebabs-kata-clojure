(ns camel-snakes-pascals-kebab.format
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

(defn resolve-transforming-fn
  "Returns the transforming function corresponding to the format passed in"
  [format]
  (resolve (symbol "camel-snakes-pascals-kebab.format" (name format))))
