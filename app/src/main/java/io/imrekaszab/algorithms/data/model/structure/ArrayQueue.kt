package io.imrekaszab.algorithms.data.model.structure

import java.util.NoSuchElementException

class ArrayQueue(capacity: Int) {
    private var queue: Array<Employee?>
    private var front = 0
    private var back = 0
    fun add(employee: Employee?) {
        if (size() == queue.size - 1) {
            val numItems = size()
            val newArray = arrayOfNulls<Employee>(2 * queue.size)
            System.arraycopy(queue, front, newArray, 0, queue.size - front)
            System.arraycopy(queue, 0, newArray, queue.size - front, back)
            queue = newArray
            front = 0
            back = numItems
        }

        queue[back] = employee
        if (back < queue.size - 1) {
            back++
        } else {
            back = 0
        }
    }

    fun remove(): Employee? {
        if (size() == 0) {
            throw NoSuchElementException()
        }
        val employee = queue[front]
        queue[front] = null
        front++
        if (size() == 0) {
            front = 0
            back = 0
        } else if (front == queue.size) {
            front = 0
        }
        return employee
    }

    fun peek(): Employee? {
        if (size() == 0) {
            throw NoSuchElementException()
        }
        return queue[front]
    }

    fun size(): Int {
        return if (front <= back) {
            back - front
        } else {
            back - front + queue.size
        }
    }

    fun printQueue() {
        if (front <= back) {
            for (i in front until back) {
                println(queue[i])
            }
        } else {
            for (i in front until queue.size) {
                println(queue[i])
            }
            for (i in 0 until back) {
                println(queue[i])
            }
        }
    }

    init {
        queue = arrayOfNulls(capacity)
    }
}