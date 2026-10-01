def is_prime(n):
    if n < 2:
        return False
    for d in range(2, int(n ** 0.5) + 1):
        if n % d == 0:
            return False
    return True


for n in range(1, 31):
    if is_prime(n):
        print(f"{n:2d} is prime")
