<?php
namespace Test\normal;

use PHPUnit\Framework\TestCase;
use function Normal\functions\bobbleSort;

class FunctionTest extends TestCase
{
    public function insertStringToBobbleSortShouldReturnEmpty() {
        $_tmp = Normal\functions\bobbleSort('');
        self::assertEquals($_tmp, []);
    }
}