// LeetCode 284. Peeking Iterator
// https://leetcode.com/problems/peeking-iterator/
// O(1) time-and-space for all methods
class PeekingIterator {
    nextVal:number;
    iterator:Iterator;

    constructor(iterator: Iterator) {
        this.iterator = iterator;
        this.nextVal = undefined;
        this.peek();
    }

    peek(): number {
        if (this.nextVal === undefined && this.iterator.hasNext())
            this.nextVal = this.iterator.next();
        return this.nextVal;
    }

    next(): number {
        let val = this.nextVal;
        this.nextVal = undefined;
        this.peek();
        return val;
    }

    hasNext(): boolean {
        return this.nextVal !== undefined;
    }
}
