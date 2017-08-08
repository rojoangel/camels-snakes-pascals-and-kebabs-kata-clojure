(ns camel-snakes-pascals-kebab.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [camel-snakes-pascals-kebab.core :refer :all]))


(defn camel-case
  "Converts the input to camel case."
  [input]
  (def strings (str/split 
    (str/replace input #"-" " ") #" "))
  (str/join "" (concat (first strings) (map str/capitalize (drop 1 strings)))))

(deftest a-test
  (testing "The input string formated in camel-case"
    (is (= (camel-case "hello-koko") "helloKoko"))))
