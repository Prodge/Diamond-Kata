(ns clojure3.core
  (:gen-class))

(defn spaces [n]
  (apply str (repeat n " ")))

(defn row-letter [row]
  (-> (int \a) (+ row) char str))

(defn letter-at-pos [letter pos width]
  (str (spaces pos) letter (spaces (- width pos))))

(defn line-string [line order]
  (let [corner (letter-at-pos (row-letter line) (- order line) order)]
    (apply str corner (reverse (butlast corner)))))

(defn get-diamond-top [order]
  (loop [line 0 diamond []]
    (if (<= line order)
      (recur (inc line) (conj diamond (line-string line order)))
      diamond)))

(defn get-diamond [order]
  (let [top (get-diamond-top order)]
    (into top (reverse (butlast top)))))

(defn -main [arg]
  (let [order (-> arg first int (- (int \a)))]
    (doall (map println (get-diamond order)))))
