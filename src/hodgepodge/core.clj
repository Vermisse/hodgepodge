(ns hodgepodge.core)

((fn [x] (println x)) "closure")

(defn lambda[x] (x "lambda"))
(lambda (fn [x] (println x)))

(defn curring[x] (fn [y] (Math/pow x y)))
(let [x (curring 2) y (x 8)] (println y))

((fn [& x] "fusion" 
   (let [y (filter integer? x)
         z (filter even? y)]
     (reduce * z))) 1 2 3 "4" 5)

((fn [o]
   (let [n (reverse o) f (fn [x] (take-nth 2 x)) s (concat (f n) (f (rest n)))]
     ((fn re[x y] (cond (> (count x) 0)(re (rest x) (str y (first x))) true y)) s ""))
   ) "this")

((fn [o]
   (let [n (reverse o)
         v (rest n)
         f (fn [x] (take-nth 3 x))
         s (concat (f v) (f (rest v)) (f n))]
     ((fn r [x y]
        (cond
          (> (count x) 0) (r (rest x) (str y (first x))) true y)
        ) s ""))
   ) "40561152515")

(map #(* % %)(range 1 10))