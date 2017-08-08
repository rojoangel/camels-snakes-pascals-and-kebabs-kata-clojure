(ns camel-snakes-pascals-kebab.core-test
  (:require [clojure.test :refer :all]
            [camel-snakes-pascals-kebab.core :refer :all]))

(deftest a-test
  (testing "The input string formated in camel-case"
    (is (= (camel-case "hello-koko") "helloKoko"))))
