package com.abc

import scala.collection.mutable.ListBuffer

class Bank {
  var customers = new ListBuffer[Customer]

  def addCustomer(customer: Customer) {
    customers += customer
  }

  def customerSummary: String = {
    var summary: String = "Customer Summary"
    for (customer <- customers)
      summary = summary + "\n - " + customer.name + " (" + format(customer.numberOfAccounts, "account") + ")"
    summary
  }

  private def format(number: Int, word: String): String = {
    number + " " + (if (number == 1) word else word + "s")
  }

  def totalInterestPaid: Double = {
    val total: Double = customers.map(_.totalInterestEarned).sum
    /*for {
      c <- customers
    } yield c.totalInterestEarned*/
    total
  }

  def getFirstCustomer: String = {
    try {
      if (customers.nonEmpty)
        customers.head.name
      else
        "None"
    }
    catch {
      case e: Exception =>
        e.printStackTrace()
        "Error"
    }
  }

}


