(ns clojure2.core
  (:gen-class))

(def asci-a (int \a))

(defn spaces [n]
  (apply str (repeat n " ")))

(defn start-spaces [line order]
  (spaces (- order line)))

(defn middle-spaces [line]
  (spaces (dec (* 2 line))))

(defn row-letter [row]
  (-> asci-a (+ row) char str))

(defn line-string [line order]
  (if (= line 0)
    (str (spaces order) "a")
    (str (start-spaces line order) (row-letter line) (middle-spaces line) (row-letter line))))

(defn get-diamond-top [order]
  (loop [line 0 diamond []]
    (if (<= line order)
      (recur (inc line) (conj diamond (line-string line order)))
      diamond)))

(defn get-diamond [order]
  (let [top (get-diamond-top order)]
    (apply conj top (reverse (butlast top)))))

(defn -main
  "Diamond Kata by Prodge"
  [arg]
  (let [order (- (int (.charAt arg 0)) asci-a)]
    (doall (map println (get-diamond order)))))

