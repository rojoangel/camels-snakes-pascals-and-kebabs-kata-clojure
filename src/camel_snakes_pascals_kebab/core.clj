(ns camel-snakes-pascals-kebab.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn camel-case
  "Converts the input to camel case."
  [input]
  (let [strings (str/split 
    (str/replace input #"-" " ") #" ")]
  (str/join "" (concat (first strings) (map str/capitalize (drop 1 strings))))))

(defn snake-case
  "Converts the input to snake case."
  [input]
  (str/replace input #"-" "_"))

(defn pascal-case
  "Converts the input to pascal case."
  [input]
  (let [strings (str/split 
    (str/replace input #"-" " ") #" ")]
  (str/join "" (map str/capitalize strings))))
 (defn kebab-case
  "Converts the input to pascal case."
  [input]
  input)

(defn format
  "Formats the input with a given transformer function"
  [input using transformer]
  (keyword (let [unformatted (name input)]
    ((resolve (symbol "camel-snakes-pascals-kebab.core" (name transformer))) unformatted))))