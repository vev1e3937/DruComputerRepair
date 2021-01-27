package com.example.drucomputerrepair.data.map

import com.example.drucomputerrepair.data.database.Problem
import com.example.drucomputerrepair.data.models.ProblemModel
import org.jetbrains.exposed.sql.ResultRow

object ProblemMap {
    fun toProblem(row: ResultRow)=ProblemModel(
        problem_id = row[Problem.problem_id],
        problem_name = row[Problem.problem_name]
    )
}