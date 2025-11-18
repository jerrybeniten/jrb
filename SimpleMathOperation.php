<?php

/**
 * This simple math function demonstrates how the basic Beniten Language works.
 * PHP has been the inspiratopm of this language.
 */

/**
 * This is a simple addition operation.
 *
 * @param float $a  First input parameter.
 * @param float $b  Second input parameter.
 * @return float
 */
function addition(float $a, float $b): float {
    return $a + $b;
}

/**
 * This is a simple subtraction operation.
 *
 * @param float $a  First input parameter.
 * @param float $b  Second input parameter.
 * @return float
 */
function subtraction(float $a, float $b): float {
    return $a - $b;
}

/**
 * This is a simple multiplication operation.
 *
 * @param float $a  First input parameter.
 * @param float $b  Second input parameter.
 * @return float
 */
function multiplication(float $a, float $b): float {
    return $a * $b;
}


/**
 * This is a simple division operation.
 *
 * @param float $a  First input parameter.
 * @param float $b  Second input parameter.
 * @return float
 */
function division(float $a, float $b): float {
    return $a / $b;
}
echo "\n";
echo 'Addition';
(float) $add = addition(5.1, 1.0);
echo "\n";
echo $add;

echo "\n";
echo "Subtraction";
(float) $sub = subtraction(5.1, 0.1);
echo "\n";
echo $sub;

echo "\n";
echo "Multiplication";
(float) $mul = multiplication(2.0, 2.1);
echo "\n";
echo $mul;

echo "\n";
echo "Division";
(float) $div = division(4.0, 2.0);
echo "\n";
echo $div;

// Condition demonstration.
// Single commenting capability.
if ($add > $mul) {
    echo "\n";
    echo "Addition is greater than multiplication.";
} else if ($add < $mul) {
    echo "\n";
    echo "Multiplication is greater than addition.";
} else {
    echo "\n";
    echo "They could be equal";
}

// Boolean testing
(bool) $isTrue=true;

if ($isTrue===true) {
    echo "\n";
    echo "TYPE CHECKED";
}

if ($isTrue==true) {
    echo "\n";
    echo "Simillarity check without strict comparison";
}

if ($isTrue==='true') {
    echo "\n";
    echo "Simillarity check without strict comparison";
} else {
    echo "\n";
    echo "Do not compare apples and bananas";
}

// Loop demonstration.
(int) $counter = 0;
	
while ($counter < 6) {
    echo "\n";
    echo $counter;

    if ($counter===0) {
        echo "\n";
        echo 'Hey it is zero';
    } else if ($counter===1) {
        echo "\n";
        echo 'Lets celebrate and count to one';
    } else if ($counter===2) {
        echo "\n";
        echo "Double quote on two";
    } else if ($counter===3) {
        echo "\n";
        echo "Still double at three";
    } else if ($counter===4) {
        echo "\n";
        echo "Display addition total at four";
        echo "\n";
        echo $add;
    } else {
        echo "\n";
        echo "Lets rest at five";
    }
    
    $counter = $counter + 1;
}
