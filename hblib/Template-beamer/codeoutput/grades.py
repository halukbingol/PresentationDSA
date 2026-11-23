grades = {"Ayşe": 91, "Mehmet": 78, "Zeynep": 85, "Çağrı": 67}

for name, grade in sorted(grades.items(), key=lambda kv: -kv[1]):
    print(f"{name:<8} {grade:3d}  {'*' * (grade // 10)}")

average = sum(grades.values()) / len(grades)
print(f"Öğrenci sayısı: {len(grades)}, ortalama: {average:.1f}")
