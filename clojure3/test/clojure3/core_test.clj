(ns clojure3.core-test
  (:require [clojure.test :refer :all]
            [clojure3.core :refer :all]))

(deftest test-spaces
  (testing "The correct number of spaces is returned"
    (is (= (spaces 0) ""))
    (is (= (spaces 1) " "))
    (is (= (spaces 2) "  "))
    ))

(deftest letter-at-pos-test
  (testing "Getting a getting a string with a letter at the set pos"
    (is (= (letter-at-pos "a" 0 4) "a    "))
    (is (= (letter-at-pos "a" 1 4) " a   "))
    (is (= (letter-at-pos "a" 2 4) "  a  "))
    (is (= (letter-at-pos "a" 3 4) "   a "))
    (is (= (letter-at-pos "a" 4 4) "    a"))
    ))

(deftest line-char-test
  (testing "Getting a character at a given line"
    (is (= (row-letter 0) "a"))
    (is (= (row-letter 1) "b"))
    (is (= (row-letter 2) "c"))
    ))

(deftest line-string-test
  (testing "Generating the string to be printed on the given line"
    (is (= (line-string 0 2)  "  a  "))
    (is (= (line-string 1 2 ) " b b "))
    (is (= (line-string 2 2)  "c   c"))))

(deftest get-diamond-top-test
  (testing "The collection for the top of the diamond"
    (is (= (get-diamond-top 2) ["  a  "
                                " b b "
                                "c   c"]))))

(deftest get-diamond-test
  (testing "The collection for the final structure is valid"
    (is (= (get-diamond 2)
           ["  a  "
            " b b "
            "c   c"
            " b b "
            "  a  "]))))
