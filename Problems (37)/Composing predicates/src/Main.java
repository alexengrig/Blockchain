/**
 * The method represents a disjunct operator for a list of predicates.
 * For an empty list it returns the always false predicate.
 */
public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
    if (predicates.isEmpty()) {
        return i -> false;
    } else {
        IntPredicate target = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            target = target.or(predicates.get(i));
        }
        return target;
    }
}