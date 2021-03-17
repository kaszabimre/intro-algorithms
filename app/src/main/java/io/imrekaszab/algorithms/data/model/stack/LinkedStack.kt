package io.imrekaszab.algorithms.data.model.stack

import java.util.LinkedList

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class LinkedStack {
    private val stack: LinkedList<Employee> = LinkedList()

    fun push(employee: Employee) {
        stack.push(employee)
    }

    fun pop(): Employee {
        return stack.pop()
    }

    fun peek(): Employee {
        return stack.peek()
    }

    val isEmpty: Boolean
        get() = stack.isEmpty()

    fun printStack() {
        for (employee in stack) {
            println(employee)
        }
    }

}