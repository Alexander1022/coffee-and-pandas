export default interface EventInterface {
    id?: number | null,
    name: string,
    description: string,
    date: string,
    creatorId: string | null,
    placeDto: {
        name: string
        description: string,
        placeType: string,
        coordinates: string
    }
}