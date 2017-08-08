(ns camel-snakes-pascals-kebab.core-test
  (:require [clojure.test :refer :all]
            [camel-snakes-pascals-kebab.core :refer :all]))

(deftest a-test
  (testing "The input string formated in camelCase"
    (is (= (format :hello-koko :using :camel-case) :helloKoko)))
  (testing "The input string formated in snake_case"
    (is (= (format :hello-koko :using :snake-case) :hello_koko)))
  (testing "The input string formated in PascalCase"
    (is (= (format :hello-koko :using :pascal-case) :HelloKoko)))
  (testing "The input string formated in kebab-case"
    (is (= (format :hello-koko :using :kebab-case) :hello-koko)))
  (testing "The input string formated in kebab-case"
    (is (= (format :helloKoko :using :kebab-case) :hello-koko)))
  (testing "The input string formated in kebab-case"
    (is (= (format :helloKitty :using :pascal-case) :HelloKitty))))
