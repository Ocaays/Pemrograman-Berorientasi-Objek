import random

# Data contoh
teachers = ['Guru A', 'Guru B', 'Guru C']
subjects = ['Matematika', 'Fisika', 'Kimia']
classes = ['Kelas 1', 'Kelas 2', 'Kelas 3']
timeslots = ['Senin P1', 'Senin P2', 'Selasa P1', 'Selasa P2']

# Representasi kromosom: [guru, mata pelajaran, kelas, waktu]
def create_individual():
    return [
        random.choice(teachers),
        random.choice(subjects),
        random.choice(classes),
        random.choice(timeslots)
    ]

# Fungsi fitness: menghitung jumlah bentrok jadwal
# Konflik terjadi jika kelas dan waktu sama dengan jadwal sebelumnya
def fitness(individual, schedule):
    conflicts = 0
    for scheduled in schedule:
        if individual[2] == scheduled[2] and individual[3] == scheduled[3]:
            conflicts += 1
    return conflicts

# Seleksi: memilih dua individu berdasarkan fitness terbaik
def selection(population, schedule):
    sorted_population = sorted(population, key=lambda ind: fitness(ind, schedule))
    return sorted_population[:2]

# Crossover: pertukaran informasi antara dua individu
def crossover(parent1, parent2):
    crossover_point = random.randint(1, 3)
    child1 = parent1[:crossover_point] + parent2[crossover_point:]
    child2 = parent2[:crossover_point] + parent1[crossover_point:]
    return child1, child2

# Mutasi: perubahan acak pada individu
def mutate(individual):
    mutation_point = random.randint(0, 3)
    if mutation_point == 0:
        individual[mutation_point] = random.choice(teachers)
    elif mutation_point == 1:
        individual[mutation_point] = random.choice(subjects)
    elif mutation_point == 2:
        individual[mutation_point] = random.choice(classes)
    else:
        individual[mutation_point] = random.choice(timeslots)
    return individual

# Algoritma Genetika utama
def genetic_algorithm():
    population_size = 10
    generations = 50
    population = [create_individual() for _ in range(population_size)]
    schedule = []

    for generation in range(generations):
        new_population = []

        for _ in range(population_size // 2):
            parent1, parent2 = selection(population, schedule)
            child1, child2 = crossover(parent1, parent2)
            new_population.extend([mutate(child1), mutate(child2)])

        population = new_population
        best_individual = min(population, key=lambda ind: fitness(ind, schedule))
        schedule.append(best_individual)
        print(f"Generasi {generation + 1}: {best_individual} | Fitness: {fitness(best_individual, schedule)}")

    print("\nJadwal Akhir:")
    for ind in schedule:
        print(f"{ind[2]} - {ind[1]} oleh {ind[0]} pada {ind[3]}")

# Jalankan algoritma
genetic_algorithm()