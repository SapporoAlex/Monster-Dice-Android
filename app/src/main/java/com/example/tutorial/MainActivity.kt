package com.example.tutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val messageOverlay = findViewById<View>(R.id.messageOverlay)
        val messageBox = findViewById<View>(R.id.messageBox)
        val messageText = findViewById<TextView>(R.id.messageText)
        val okButton = findViewById<Button>(R.id.okButton)

        okButton.setOnClickListener {
            messageOverlay.visibility = View.GONE
        }

        val arrowTrapRangedButton = findViewById<Button>(R.id.arrowTrapRanged)
        arrowTrapRangedButton.setOnClickListener {
            var crit = false
            val attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            var damage = 0
            val damageRoll1 = rollDice(1, 10)
            val damageRoll2 = rollDice(1, 10)
            damage = damageRoll1 + damageRoll2
            if (crit) {
                damage *= 2
            }
            if (crit) {
                showMessage(
                    "The arrow trap hits it's mark precisely for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The arrow trap fires for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val banditMeleeButton = findViewById<Button>(R.id.banditMelee)
        banditMeleeButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 3
            var damage = 1
            var damageRoll = rollDice(1, 6)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The bandit slashes a vital area for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The bandit slashes with scimitar for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val banditRangedButton = findViewById<Button>(R.id.banditRanged)
        banditRangedButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 3
            var damage = 1
            var damageRoll = rollDice(1, 8)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The bandit shoots a bull's eye for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The bandit fires crossbow for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val basaliskBiteButton = findViewById<Button>(R.id.basaliskBite)
        basaliskBiteButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            val damageRoll = rollDice(1, 10)
            val secondDamageRoll = rollDice(1, 10)

            val poisonDamageRoll = rollDice(1, 6)
            val secondPoisonDamageRoll = rollDice(1, 6)
            var damageRollTotal = damageRoll + secondDamageRoll + 3
            if (crit) {
                damageRollTotal *= 2
            }
            var poisonDamageTotal = poisonDamageRoll + secondPoisonDamageRoll
            if (crit) {
                showMessage(
                    "The basilisk chomps down for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damageRollTotal damage, and $poisonDamageTotal poison damage.",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The basilisk bites for $attackRoll attack and deals $damageRollTotal damage, and $poisonDamageTotal poison damage.",
                    messageOverlay,
                    messageText
                )
            }
        }

        val darkMantleCrushButton = findViewById<Button>(R.id.darkMantleCrush)
        darkMantleCrushButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 3
            var damageRoll = rollDice(1, 8)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The dark mantle pulverizes for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The dark mantle crushes for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val direwolfBiteButton = findViewById<Button>(R.id.direwolfBite)
        direwolfBiteButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 3
            var damageRoll = rollDice(1, 8)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The dire wolf savagely mauls for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The dire wolf bites for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val ghastBiteButton = findViewById<Button>(R.id.ghastBite)
        ghastBiteButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 3
            var damage = 3
            var damageRoll = rollDice(1, 8)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The ghast tears at the player for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The ghast bites for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val ghastClawsButton = findViewById<Button>(R.id.ghastClaws)
        ghastClawsButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 3
            var damageRoll = rollDice(1, 6)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The ghast brutally claws for $attackRoll attack and deals $damage damage \uD83D\uDCA5Nat20\uD83D\uDCA5! The player must succeed a DC10 constitution save or be paralysed for 1 minute.",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The ghast slashes with claws for $attackRoll attack and deals $damage damage! The player must succeed a DC10 constitution save or be paralysed for 1 minute.",
                    messageOverlay,
                    messageText
                )
            }
        }

        val guardMeleeButton = findViewById<Button>(R.id.guardMelee)
        guardMeleeButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 3
            var damage = 1
            var damageRoll = rollDice(1, 8)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The guard expertly thrusts the spear for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The guard thrusts spear for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val knightMeleeButton = findViewById<Button>(R.id.knightMelee)
        knightMeleeButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 3
            var damageRoll = rollDice(1, 6)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            var secondCrit = false
            var secondAttackRoll = rollDice(1, 20)
            if (secondAttackRoll == 20) {
                secondCrit = true
            }
            secondAttackRoll += 5
            var secondDamage = 3
            var secondDamageRoll = rollDice(1, 6)
            if (secondCrit) {
                secondDamageRoll *= 2
            }
            secondDamage += secondDamageRoll

            val message = when {
                crit && secondCrit ->
                    "The knight makes two consecutive perfect strikes with greatsword for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5 \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage with the first, then $secondDamage damage on the second!"

                crit ->
                    "The knight strikes with perfect precision with $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage, then swings again for $secondAttackRoll attack and $secondDamage damage!"

                secondCrit ->
                    "The knight swings the greatsword for $attackRoll attack, and deals $damage damage, then gracefully follows up with a perfectly aimed swing for $secondAttackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and $secondDamage damage!"

                else ->
                    "The knight attacks with greatsword for $attackRoll attack and deals $damage damage, then attacks again for $secondAttackRoll attack and $secondDamage damage!"
            }
            showMessage(message, messageOverlay, messageText)
        }

        val knightRangedButton = findViewById<Button>(R.id.knightRanged)
        knightRangedButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 2
            var damage = 0
            var damageRoll = rollDice(1, 10)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The knight's crossbow bolt hits its mark for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The knight fires heavy crossbow for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val orcMeleeButton = findViewById<Button>(R.id.orcMelee)
        orcMeleeButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 3
            var damageRoll = rollDice(1, 12)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The orc savagely swings great axe for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The orc attacks with great axe for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val orcRangedButton = findViewById<Button>(R.id.orcRanged)
        orcRangedButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 3
            var damageRoll = rollDice(1, 6)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The orc yeets javelin for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The orc attacks with javelin for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }


        val owlbearMeleeButton = findViewById<Button>(R.id.owlbearMelee)
        owlbearMeleeButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 7
            var damage = 5
            var damageRoll = rollDice(1, 10)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            var secondCrit = false
            var secondAttackRoll = rollDice(1, 20)
            if (secondAttackRoll == 20) {
                secondCrit = true
            }
            secondAttackRoll += 7
            var secondDamage = 5
            var secondDamageTotal = 0
            for (i in 1..2) {
                val secondDamageRoll = rollDice(1, 8)
                secondDamageTotal += secondDamageRoll
            }
            if (secondCrit) {
                secondDamageTotal *= 2
            }
            secondDamage += secondDamageTotal
            val message = when {
                crit && secondCrit ->
                    "The owlbear strikes down hard with beak for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage, then viciously slashes with claws for $secondAttackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and $secondDamageTotal damage!"

                crit ->
                    "The owlbear strikes down hard with beak for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage, then attacks with claws for $secondAttackRoll attack and $secondDamageTotal damage!"

                secondCrit ->
                    "The owlbear attacks with beak for $attackRoll attack, and deals $damage damage, then viciously slashes with claws for $secondAttackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and $secondDamageTotal damage!"

                else ->
                    "The owlbear attacks with beak for $attackRoll attack and deals $damage damage, then attacks with claws for $secondAttackRoll attack and $secondDamageTotal damage!"
            }

            showMessage(message, messageOverlay, messageText)
        }

        val skeletonWarriorMeleeButton = findViewById<Button>(R.id.skeletonMelee)
        skeletonWarriorMeleeButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 4
            var damage = 2
            var damageRoll = rollDice(1, 6)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll
            if (crit) {
                showMessage(
                    "The skeleton warrior fiercely a weak spot for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The skeleton warrior slashes short sword for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val skeletonWarriorRangedButton = findViewById<Button>(R.id.skeletonRanged)
        skeletonWarriorRangedButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 5
            var damage = 2
            var damageRoll = rollDice(1, 6)
            if (crit) {
                damageRoll *= 2
            }
            damage += damageRoll

            if (crit) {
                showMessage(
                    "The skeleton warrior launches arrow with deadly accuracy for $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The skeleton warrior shoots short bow for $attackRoll attack and deals $damage damage!",
                    messageOverlay,
                    messageText
                )
            }
        }

        val snakeBiteButton = findViewById<Button>(R.id.snakeBite)
        snakeBiteButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 4
            var damage = 1
            val poisonDamageRoll = rollDice(1, 4)
            if (crit) {
                damage = 2
            }
            val secondPoisonDamageRoll = rollDice(1, 4)
            val totalPoisonDamage = poisonDamageRoll + secondPoisonDamageRoll
            val halfTotalPoisonDamage = ceil(totalPoisonDamage / 2.0).toInt()

            if (crit) {
                showMessage(
                    "The snake strikes like lightning with $attackRoll attack \uD83D\uDCA5Nat20\uD83D\uDCA5, and deals $damage damage. Player must succeed on a DC10 constitution save or take $totalPoisonDamage poison damage. Successful save deals $halfTotalPoisonDamage poison damage.",
                    messageOverlay,
                    messageText
                )
            } else {
                showMessage(
                    "The snake bites with $attackRoll attack and deals $damage damage. Player must succeed on a DC10 constitution save or take $totalPoisonDamage poison damage. Successful save deals $halfTotalPoisonDamage poison damage.",
                    messageOverlay,
                    messageText
                )
            }
        }

        val spiderBiteButton = findViewById<Button>(R.id.spiderBite)
        spiderBiteButton.setOnClickListener {
            var crit = false
            var attackRoll = rollDice(1, 20)
            if (attackRoll == 20) {
                crit = true
            }
            attackRoll += 4
            var damage = 1
            val poisonDamageRoll = rollDice(1, 4)
            if (crit) {
                damage = 2
            }
            val halfTotalPoisonDamage = ceil(poisonDamageRoll / 2.0).toInt()

            if (crit) {
                showMessage(
                    "The spider sinks it's fangs in deep with $attackRoll attack and deals $damage damage \uD83D\uDCA5Nat20\uD83D\uDCA5. Player must succeed on a DC9 constitution save or take $poisonDamageRoll poison damage. Successful save deals $halfTotalPoisonDamage poison damage.",
                    messageOverlay,
                    messageText
                )
            }
            else
            showMessage(
                "The spider bites with $attackRoll attack and deals $damage damage. Player must succeed on a DC9 constitution save or take $poisonDamageRoll poison damage. Successful save deals $halfTotalPoisonDamage poison damage.",
                messageOverlay,
                messageText
            )
        }
    }

    private fun rollDice(min: Int, max: Int): Int {
        return (min..max).random()
    }

    private fun showMessage(text: String, overlay: View, messageText: TextView) {
        messageText.text = text
        overlay.visibility = View.VISIBLE
        findViewById<View>(R.id.messageBox).visibility = View.VISIBLE
    }
}