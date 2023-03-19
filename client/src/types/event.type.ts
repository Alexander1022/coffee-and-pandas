export default interface EventInterface {
    id?: number | null,
    name: string,
    description: string,
    date: string,
    creatorId: string,
    placeDto: {
        name: string
        description: string,
        placeType: string,
        coordinates: string
    }
}