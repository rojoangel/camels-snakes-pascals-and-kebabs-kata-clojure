(ns camel-snakes-pascals-kebab.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn camel-case
  "Converts the input to camel case."
  [input]
  (let [strings (str/split 
    (str/replace input #"-" " ") #" ")]
  (str/join "" (concat (first strings) (map str/capitalize (drop 1 strings))))))