package com.ironyard.entities;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by graceconnelly on 1/22/17.
 */
@Entity
@Table(name = "mastermind_game")
public class MastermindGame {
    @Id
    @GeneratedValue
   int id;

    @Column
    ArrayList <Play> plays;

    @Column
    ArrayList <Check> checks;
}
